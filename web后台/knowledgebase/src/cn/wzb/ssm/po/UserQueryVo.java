package cn.wzb.ssm.po;

public class UserQueryVo {
	/**
	 * 用户信息
	 */
	private User user;
	/**
	 * 对原始生成的po进行扩展
	 */
	private UserCustom userCustom;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

}
