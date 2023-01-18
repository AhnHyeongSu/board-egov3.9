package egovframework.example.board.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;
import egovframework.example.board.service.Criteria;
import egovframework.example.board.service.Paging;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	
	/* 게시판 리스트 */
	@RequestMapping(value = "/list.do")
	public String list(Criteria cri, ModelMap model) throws Exception {
		
		// 전체 글 개수
        int boardListCnt = boardService.boardListCnt();
        
        // 페이징 객체
        Paging paging = new Paging();
        
        paging.setCri(cri);
        paging.setTotalCount(boardListCnt);    
        
        
        List<BoardVO> list = new ArrayList<BoardVO>();
        list = boardService.boardList(cri);
        
        model.addAttribute("boardlist", list);    
        model.addAttribute("paging", paging);
        model.addAttribute("pageNum", cri.getPage());
        
		return "board/list";
	}
	
	/* 게시글 보기 */
	@RequestMapping(value = "/boardView.do")
	public String boardView(@RequestParam("boardNum") int boardNum, ModelMap model) throws Exception {
		
		BoardVO boardView = new BoardVO();
		boardView = boardService.boardView(boardNum);
		model.addAttribute("boardView", boardView);
		
		return "board/boardView";
	}
	
	/* 게시글 등록창 */
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(ModelMap model) throws Exception {
		return "board/insertBoard";
	}
	
	/*게시글 등록하기*/  //다른 메소드와 같이 리턴값으로 성공실패 여부 처리
	@RequestMapping(value = "/addBoard.do")
	public String addBoard(BoardVO boardVO, ModelMap model, HttpServletResponse response) throws Exception {
		
		int result = 0;
		
		try {	// !!! 공동 코드들은 finally에서 쓰고 catch문에서 return 할 필요 없이 try 문에서 성공실패 여부 리턴 해줘야한다
			result = boardService.addBoard(boardVO);
			
			model.addAttribute("result", result);
			return "redirect:/list.do";
		} catch(Exception e) {
			model.addAttribute("result", result);
			e.printStackTrace();
			return "redirect:/list.do";
		}
	}

	/*게시글 수정창*/
	@RequestMapping(value="/updateBoardView.do")
	public String updateBoardView(BoardVO boardVO, ModelMap model) throws Exception {
		model.addAttribute("oldText", boardVO);
		return "board/updateBoardView";
	}
	
	/*게시글 수정  JSTL로 성공실패 여부 alert 구현 해야함*/
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO boardVO, ModelMap model) throws Exception {
		int result = 0;
		
		try {
			//성공시 반환값 1
			result = boardService.updateBoard(boardVO);
			model.addAttribute("result", result);
			return "redirect:/list.do";
			
		} catch(Exception e) {
			//실패 시 반환값 0 
			model.addAttribute("result", result);
			e.printStackTrace();
			return "redirect:/list.do";
		}
			
	}
	
	/*게시글 삭제*/
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO boardVO, ModelMap model) throws Exception {
		int result = 0;
		
		try {
			//성공시 반환값 1
			result = boardService.deleteBoard(boardVO);
			model.addAttribute("result", result);
			return "redirect:/list.do";
			
		} catch(Exception e) {
			//실패시 반환값 0
			model.addAttribute("result", result);
			//e.printStackTrace(); // 이거는 로직도 다 보이기 때문에 보안성에 취약하다. 고로 밑에 있는 e.message를 사용하자
			e.getMessage();
			return "redirect:list.do";
		}
			
	}
	
	/*비밀번호 체크*/
	@ResponseBody
	@RequestMapping(value="/pwdCheck.do")
	public String pwdCheck(@RequestParam("num") int num, @RequestParam("checkPwd") String checkpwd, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int result = 0;
		String pwd = "";
		String str = "";
		
		pwd = boardService.pwdConfirm(num);
		
		if(pwd.equals(checkpwd)) { //!!! 만약 pwd가 null이면 nullpointException 발생한다. 그러니 equals는 앞에거가 null이 아닌걸로 써라
			Map<String, Object> checkMap = new HashMap<String, Object>(); // !!! vo활용
			checkMap.put("boardNum", num);
			checkMap.put("checkPwd", checkpwd);
			
			result = boardService.pwdCheck(checkMap);
			str = String.valueOf(result); 	
		}
		
		//성공 시 반환값 1
		return str;	
	}
}
