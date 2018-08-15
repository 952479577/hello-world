package com.yc.biz;

import com.yc.bean.User;

public interface UserBiz {
	/**ע���û�
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	/**�û����Ƿ����
	 * @param user
	 * @return
	 */
	public boolean validate(User user);
	/**����ID���û�
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	/**��¼
	 * @param user
	 * @return
	 */
	public User login(User user);
}
