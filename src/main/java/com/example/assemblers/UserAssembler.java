package com.example.assemblers;

import com.example.domain.User;
import com.example.utils.UserUtil;
import com.example.vo.CreateUserVO;
import com.example.vo.UpdateUserVO;
import com.example.vo.UserVO;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

    /**
     * CreateUserVO convert to User.
     *
     * @param createUserVO
     * @return
     */
    public User toUser(CreateUserVO createUserVO) {
        User user = new User();
        user.setFirstName(createUserVO.getFirstName());
        user.setLastName(createUserVO.getLastName());
        user.setUsername(createUserVO.getUserName());
        return user;
    }


    /**
     * User to UserVO.
     *
     * @param user
     * @return
     */
    public UserVO toUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setUserId(user.getId());
        userVO.setFullName(UserUtil.convertToFullName(user.getFirstName(), user.getLastName()));
        userVO.setUserName(user.getUsername());
        return userVO;

    }

    /**
     * UpdateUserVO to user.
     *
     * @param updateUserVO
     * @return
     */
    public User toUser(UpdateUserVO updateUserVO) {
        User user = new User();
        user.setId(updateUserVO.getUserId());
        user.setFirstName(updateUserVO.getFirstName());
        user.setLastName(updateUserVO.getLastName());
        user.setUsername(updateUserVO.getUserName());
        return user;
    }
}