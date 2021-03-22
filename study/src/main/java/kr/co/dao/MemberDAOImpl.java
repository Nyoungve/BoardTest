package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject SqlSession sql;
	// 회원가입

	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert("memberMapper.register", vo);
	}
	@Override
	public MemberVO login(MemberVO vo) throws Exception{
		return sql.selectOne("memberMapper.login", vo);
	}
	//서비스에서보낸 파라미터들 memberUpdate(MemberVO vo)에 담는다. 
	@Override
	public void memberUpdate(MemberVO vo) throws Exception{
		sql.update("memberMapper.memberUpdate",vo);
	}
	// 업데이트와 마찬가지로 흐름은 같음.
	@Override
	public void memberDelete(MemberVO vo) throws Exception{
		sql.delete("memberMapper.memberDelete",vo);
	}
	// 패스워드 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.passChk", vo);
		return result;
	}
	// 아이디 중복 체크
	@Override
	public int idChk(MemberVO vo) throws Exception{
		int result = sql.selectOne("memberMapper.idChk", vo);
		return result;
	}
}
