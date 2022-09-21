package com.euphoria.shop.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.euphoria.shop.common.Exception.ApiException;
import com.euphoria.shop.common.Exception.ResultCode;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    //存进客户端的token的key名
    public static final String USER_LOGIN_TOKEN = "USER_LOGIN_TOKEN";

    @Autowired
    private RedisUtil getRedisUtil;
    @Autowired
    private static RedisUtil redisUtil;

    @PostConstruct
    public void init(){
        redisUtil = getRedisUtil;
    }
    /**
     * 签发对象：这个用户的id
     * 签发时间：现在
     * 有效时间：30分钟
     * 载荷内容：暂时设计为：这个人的名字
     * 加密密钥：这个人的id加上一串字符串
     */

    //定义token返回头部
    public static String header;
    //token前缀
    public static String tokenPrefix;
    //签名密钥

    public static String secret;
    //有效期
    public static long expireTime;

    /**
     * 创建token
     *
     * @param userId
     * @return
     */
    public static String createToken(Long userId) {
        return tokenPrefix + JWT.create().withClaim("userId",userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime))
                .sign(Algorithm.HMAC512(secret));
    }
    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static Long validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getClaim("userId").asLong();
        } catch (TokenExpiredException e) {
            //token过期
            throw new ApiException(ResultCode.UNAUTHORIZED);
        } catch (Exception e) {
            throw new ApiException(ResultCode.TOKEN_VALIDATE_FAILED);
        }
    }


    /**
     * 获取userId
     *
     * @param token
     * @return
     */
    public static Long getTokenUserId(String token) {
        Long userId;
        try {
            userId = JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getClaim("userId").asLong();
        } catch (Exception e) {
            userId = null ;
        }
        return userId;
    }




    /**
     * 检查token是否需要更新
     *
     * @param token
     * @return
     */
    public static boolean isNeedUpdate(String token) {
        //获取token过期时间
        Date expiresAt = null;
        try {
            expiresAt = JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getExpiresAt();
        } catch (TokenExpiredException e) {
            return true;
        } catch (Exception e) {
            throw new ApiException(ResultCode.TOKEN_VALIDATE_FAILED);
        }
        //如果剩余过期时间少于过期时常的一般时 需要更新
        return (expiresAt.getTime() - System.currentTimeMillis()) < (expireTime >> 1);
    }

    public static String refreshToken(String token) {
        LOGGER.info("刷新token");
        Claim userId = JWT.require(Algorithm.HMAC512(secret))
                .build()
                .verify(token.replace(tokenPrefix, "")).getClaim("userId");
        redisUtil.expire("userLogin:"+userId,30 * 60 * 2);
        return  tokenPrefix + JWT.create().withClaim("userId",userId.asLong())
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime))
                .sign(Algorithm.HMAC512(secret));
    }
    /**
     * 删除 token 的前缀
     * 前端的安全规则会在token前自动生成 Bearer 字符串前缀,共7个字符,需要删掉
     */
    public static String replaceTokenPrefix(String token) {
        return token.substring(7);
    }

    public void setHeader(String header) {
        JwtUtil.header = header;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JwtUtil.tokenPrefix = tokenPrefix;
    }

    public void setSecret(String secret) {
        JwtUtil.secret = secret;
    }

    public void setExpireTime(int expireTimeInt) {
        JwtUtil.expireTime = expireTimeInt * 1000L * 60;
    }

}


