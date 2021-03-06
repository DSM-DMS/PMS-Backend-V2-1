package com.dms.pms.global.security.filter

import com.dms.pms.global.security.jwt.JwtTokenProvider
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtTokenFilter (
    private val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val token = jwtTokenProvider.resolveToken(request)

        if (token != null) {
            jwtTokenProvider.getAuthentication(token)?.let {
                SecurityContextHolder.getContext().authentication = it
            }
        }

        chain.doFilter(request, response)
    }
}