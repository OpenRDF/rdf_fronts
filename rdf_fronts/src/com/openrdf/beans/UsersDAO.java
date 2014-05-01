package com.openrdf.beans;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.openrdf.beans.Users
 * @author MyEclipse Persistence Tools
 */
public class UsersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASS = "userPass";
	public static final String USER_STATUS = "userStatus";
	public static final String ALI_PAY_ACCOUNT = "aliPayAccount";
	public static final String USER_AGE = "userAge";
	public static final String USER_BIRTHDAY = "userBirthday";
	public static final String USER_SEX = "userSex";
	public static final String USER_COUNTRY = "userCountry";
	public static final String USER_PROVINCE = "userProvince";
	public static final String USER_CITY = "userCity";
	public static final String USER_ADDRESS = "userAddress";
	public static final String USER_POST_CODE = "userPostCode";
	public static final String USER_EMAIL = "userEmail";
	public static final String USER_EMAIL1 = "userEmail1";
	public static final String USER_EMAIL2 = "userEmail2";
	public static final String USER_PHONE = "userPhone";
	public static final String USER_QQ = "userQq";
	public static final String USER_MSN = "userMsn";
	public static final String USER_BRIEF_INFRODUCTION = "userBriefInfroduction";
	public static final String USER_BALANCE = "userBalance";
	public static final String USER_OTHERS = "userOthers";

	public void save(Users transientInstance) {
		log.debug("saving Users instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.String id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getSession().get("com.openrdf.bean.Users",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List results = getSession()
					.createCriteria("com.openrdf.bean.Users")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserPass(Object userPass) {
		return findByProperty(USER_PASS, userPass);
	}

	public List findByUserStatus(Object userStatus) {
		return findByProperty(USER_STATUS, userStatus);
	}

	public List findByAliPayAccount(Object aliPayAccount) {
		return findByProperty(ALI_PAY_ACCOUNT, aliPayAccount);
	}

	public List findByUserAge(Object userAge) {
		return findByProperty(USER_AGE, userAge);
	}

	public List findByUserBirthday(Object userBirthday) {
		return findByProperty(USER_BIRTHDAY, userBirthday);
	}

	public List findByUserSex(Object userSex) {
		return findByProperty(USER_SEX, userSex);
	}

	public List findByUserCountry(Object userCountry) {
		return findByProperty(USER_COUNTRY, userCountry);
	}

	public List findByUserProvince(Object userProvince) {
		return findByProperty(USER_PROVINCE, userProvince);
	}

	public List findByUserCity(Object userCity) {
		return findByProperty(USER_CITY, userCity);
	}

	public List findByUserAddress(Object userAddress) {
		return findByProperty(USER_ADDRESS, userAddress);
	}

	public List findByUserPostCode(Object userPostCode) {
		return findByProperty(USER_POST_CODE, userPostCode);
	}

	public List findByUserEmail(Object userEmail) {
		return findByProperty(USER_EMAIL, userEmail);
	}

	public List findByUserEmail1(Object userEmail1) {
		return findByProperty(USER_EMAIL1, userEmail1);
	}

	public List findByUserEmail2(Object userEmail2) {
		return findByProperty(USER_EMAIL2, userEmail2);
	}

	public List findByUserPhone(Object userPhone) {
		return findByProperty(USER_PHONE, userPhone);
	}

	public List findByUserQq(Object userQq) {
		return findByProperty(USER_QQ, userQq);
	}

	public List findByUserMsn(Object userMsn) {
		return findByProperty(USER_MSN, userMsn);
	}

	public List findByUserBriefInfroduction(Object userBriefInfroduction) {
		return findByProperty(USER_BRIEF_INFRODUCTION, userBriefInfroduction);
	}

	public List findByUserBalance(Object userBalance) {
		return findByProperty(USER_BALANCE, userBalance);
	}

	public List findByUserOthers(Object userOthers) {
		return findByProperty(USER_OTHERS, userOthers);
	}

	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = (Users) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}