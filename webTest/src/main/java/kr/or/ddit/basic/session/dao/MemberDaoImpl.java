package kr.or.ddit.basic.session.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private static MemberDaoImpl dao;
	
	private  MemberDaoImpl() { } 
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	
	public MemberVO getLoginMember(MemberVO memVo) {
		SqlSession session = null;
		MemberVO loginMember = null;	// 반환값
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			loginMember = session.selectOne("member.getLoginMember",memVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return loginMember;
	}

}
