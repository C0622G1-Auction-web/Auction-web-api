package com.project.repository.users;

import com.project.model.users.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoficationRepository extends JpaRepository<Notification, Integer> {
    @Query(value = "select  *  from notification " +
            "where user_id = :userID ",
            nativeQuery = true)
    List<Notification> getAllByUserId(@Param("userID") Integer userId);
    @Query(value = "select  *  from notification " +
            "where is_admin = 1 ",
            nativeQuery = true)
    List<Notification> getAllNoficationByAdmin();
}
