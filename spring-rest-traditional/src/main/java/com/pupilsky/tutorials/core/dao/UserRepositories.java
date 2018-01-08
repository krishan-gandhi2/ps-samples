/**
 * 
 */
package com.pupilsky.tutorials.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pupilsky.tutorials.core.entity.EUser;

/**
 * @author mycom
 *
 */
@Repository
public interface UserRepositories extends JpaRepository<EUser,Integer> {


}
