/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;
import egovframework.example.board.service.Criteria;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : EgovBoardServiceImpl.java
 * @Description : Board Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("boardService")
@Transactional // !!! 트랜잭션 메소드별로 옵션 선택해서 사용
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

	/** BoardDAO */
	// TODO ibatis 사용
	//@Resource(name = "boardDAO")
	//private BoardDAO boardDAO;
	// TODO mybatis 사용
	@Resource(name="boardMapper")
	private BoardMapper boardDAO;
	
	@Override
	public int boardListCnt() throws Exception {
        return boardDAO.boardListCnt();
	}
 
	@Override
	public List<BoardVO> boardList(Criteria cri) throws Exception {
        return boardDAO.boardList(cri);
	}
	
	@Override
	public BoardVO boardView(int boardNum) throws Exception {
		return boardDAO.boardView(boardNum);
	}
	
	@Override
	public int addBoard(BoardVO boardVO) throws Exception {
		boardDAO.addBoard(boardVO);
		return 1;
	}
	
	@Override
	public int pwdCheck(Map<String, Object> checkMap) throws Exception {
		return boardDAO.pwdCheck(checkMap);
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		//boardDAO.updateBoard(boardVO);
		System.out.println(boardDAO.updateBoard(boardVO));
		return 1;
	}
	
	@Override
	public int deleteBoard(BoardVO boardVO) throws Exception {
		boardDAO.deleteBoard(boardVO);
		return 1;
	}
	
	@Override
	public String pwdConfirm(int num) throws Exception {
		return boardDAO.pwdConfirm(num);
	}

//	public List<BoardVO> boardList() throws Exception {
//		return boardDAO.boardList();
//	}
	
//	/** ID Generation */
//	@Resource(name = "egovIdGnrService")
//	private EgovIdGnrService egovIdGnrService;
//
//	/**
//	 * 글을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 BoardVO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	@Override
//	public String insertBoard(BoardVO vo) throws Exception {
//		LOGGER.debug(vo.toString());
//
//		/** ID Generation Service */
//		String id = egovIdGnrService.getNextStringId();
//		vo.setId(id);
//		LOGGER.debug(vo.toString());
//
//		boardDAO.insertBoard(vo);
//		return id;
//	}
//
//	/**
//	 * 글을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 BoardVO
//	 * @return void형
//	 * @exception Exception
//	 */
//	@Override
//	public void updateBoard(BoardVO vo) throws Exception {
//		boardDAO.updateBoard(vo);
//	}
//
//	/**
//	 * 글을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 BoardVO
//	 * @return void형
//	 * @exception Exception
//	 */
//	@Override
//	public void deleteBoard(BoardVO vo) throws Exception {
//		boardDAO.deleteBoard(vo);
//	}
//
//	/**
//	 * 글을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 BoardVO
//	 * @return 조회한 글
//	 * @exception Exception
//	 */
//	@Override
//	public BoardVO selectBoard(BoardVO vo) throws Exception {
//		BoardVO resultVO = boardDAO.selectBoard(vo);
//		if (resultVO == null)
//			throw processException("info.nodata.msg");
//		return resultVO;
//	}
//
//	/**
//	 * 글 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return 글 목록
//	 * @exception Exception
//	 */
////	@Override
////	public List<?> selectBoardList(BoardDefaultVO searchVO) throws Exception {
////		return boardDAO.selectBoardList(searchVO);
////	}
//
//	/**
//	 * 글 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return 글 총 갯수
//	 * @exception
//	 */
////	@Override
////	public int selectBoardListTotCnt(BoardDefaultVO searchVO) {
////		return boardDAO.selectBoardListTotCnt(searchVO);
////	}

}
