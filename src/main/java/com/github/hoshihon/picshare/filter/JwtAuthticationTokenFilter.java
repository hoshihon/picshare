package com.github.hoshihon.picshare.filter;

import com.github.hoshihon.picshare.model.LoginUser;
import com.github.hoshihon.picshare.util.JwtUtil;
import com.github.hoshihon.picshare.util.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisCache redisCache;

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("非法 token ");
        }

        String redisKey = "login:" + userid;
        LoginUser loginUser = (LoginUser) redisCache.getCacheObject(redisKey);

        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登陆 ");
        }
        //TODO: 获取权限信息封装到 usernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());


        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);

    }

//
//    /**
//     * @param request     request 前端交互诉求
//     * @param response    response 前端交互诉求
//     * @param filterChain 过滤器链, 判断是否放行
//     * @throws ServletException
//     * @throws IOException
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String token = request.getHeader("token");
//        if (!StringUtils.hasText(token)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        String userid;
//        try {
//            Claims claims = JwtUtil.parseJWT(token);
//            userid = claims.getSubject();
//        } catch (Exception e) {
//            throw new RuntimeException("非法 token ");
//        }
//
//        String redisKey = "login:" + userid;
//        LoginUser loginUser = redisCache.getCacheObject(redisKey);
//
//        if (Objects.isNull(loginUser)) {
//            throw new RuntimeException("用户未登陆 ");
//        }
//        //TODO: 获取权限信息封装到 usernamePasswordAuthenticationToken
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                new UsernamePasswordAuthenticationToken(loginUser, null, null);
//
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        filterChain.doFilter(request, response);
//
//    }

}
