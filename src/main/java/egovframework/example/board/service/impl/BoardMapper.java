/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
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

import egovframework.example.board.service.BoardVO;
import egovframework.example.board.service.Criteria;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * sample에 관한 데이터처리 매퍼 클래스
 *
 * @author  표준프레임워크센터
 * @since 2014.01.24
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2014.01.24        표준프레임워크센터          최초 생성
 *
 * </pre>
 */
@Mapper("boardMapper")
public interface BoardMapper {
	
	public List<BoardVO> boardList(Criteria cri) throws Exception;
	 
	public int boardListCnt() throws Exception;
	
	public BoardVO boardView(int boardNum) throws Exception;
	
	public void addBoard(BoardVO boardVO) throws Exception;
	
	public int pwdCheck(Map<String, Object> checkMap) throws Exception;
	
	public int updateBoard(BoardVO boardVO) throws Exception;
	
	public int deleteBoard(BoardVO boardVO) throws Exception;
	
	public String pwdConfirm(int num) throws Exception;
	
	//List<BoardVO> boardList() throws Exception;

//	/**
//	 * 글을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 BoardVO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	void insertBoard(BoardVO vo) throws Exception;
//
//	/**
//	 * 글을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 BoardVO
//	 * @return void형
//	 * @exception Exception
//	 */
//	void updateBoard(BoardVO vo) throws Exception;
//
//	/**
//	 * 글을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 BoardVO
//	 * @return void형
//	 * @exception Exception
//	 */
//	void deleteBoard(BoardVO vo) throws Exception;
//
//	/**
//	 * 글을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 BoardVO
//	 * @return 조회한 글
//	 * @exception Exception
//	 */
//	BoardVO selectBoard(BoardVO vo) throws Exception;
//
//	/**
//	 * 글 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return 글 목록
//	 * @exception Exception
//	 */
//	//List<?> selectBoardList(BoardDefaultVO searchVO) throws Exception;
//
//	/**
//	 * 글 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return 글 총 갯수
//	 * @exception
//	 */
//	//int selectBoardListTotCnt(BoardDefaultVO searchVO);

}
