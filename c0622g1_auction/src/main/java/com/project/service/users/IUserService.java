package com.project.service.users;

import com.project.dto.user.UserTopDto;

import com.project.model.users.User;
import org.springframework.stereotype.Service;

import com.project.model.users.Address;
import com.project.model.users.User;

import java.util.List;
import java.util.Optional;


@Service
public interface IUserService {

<<<<<<< HEAD
    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     * Function: to create user
     * @return void
     */
=======
>>>>>>> 92143ecfc1de062faeebce4a84d0bb271cb0d604
    void saveUser(User user, Integer addressId, Integer accountId, Integer Number);

    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     *Function: to lockAccount
     * @param id
     */
    void unlockUser(List<Integer> id);


    /**
     * By: HaiNT - Find list of users by idList
     * @return
     */
    List<User> findByIdList(List<Integer> id);



        /**
         * Created: SangDD
         * Created date: 13/12/2022
         * Function: get Top 10 users with the highest total money auction
         *
         * @param quality user quality
         * @return List<User>
         */
        List<UserTopDto> getTopAuctionUser(String quality);
<<<<<<< HEAD



}
=======
    }

    /**
     * By: HaiNT - Find list of users by param
     */
    List<User> getUserBy(String id, String name, String email, String userTypeId, String address);

    /**
     * By: HaiNT - Find list of users by id
     *
     * @param id
     */
    Optional<User> findById(Integer id);

    /**
     * By: HaiNT - Find list of users by idList
     *
     * @return
     */
    List<User> findByIdList(List<Integer> id);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Address> findByAddressId(int id);

    void updateAddress(User user);

    void updateUser(User user);

    void unlockUser(List<Integer> idList);


    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */
    List<UserTopDto> getTopAuctionUser(String quality);

}

>>>>>>> 92143ecfc1de062faeebce4a84d0bb271cb0d604
