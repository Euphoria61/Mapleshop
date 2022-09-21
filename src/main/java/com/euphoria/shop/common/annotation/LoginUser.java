package com.euphoria.shop.common.annotation;

import java.lang.annotation.*;

/**
 * @author: Euphoria
 * @description: 获取登录用户信息
 * @date: 2022/8/7 8:22
 */
@Target(value = {ElementType.PARAMETER}) //只能被使用在方法上面
@Retention(RetentionPolicy.RUNTIME)
//设置注解的生命力在运行期，那么这个注解可以在运行期的加载阶段被加载到Class对象中。那么在程序运行阶段，我们可以通过反射得到这个注解，并通过判断是否有这个注解或这个注解中属性的值，从而执行不同的程序代码段
@Documented
//获取登录用户信息
public @interface LoginUser {

}
