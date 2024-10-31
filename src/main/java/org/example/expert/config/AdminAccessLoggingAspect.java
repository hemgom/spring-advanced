package org.example.expert.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Admin Access")
@Aspect
@Component
public class AdminAccessLoggingAspect {
	@Before("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..))")
	public void writeLogForCommentDelete() {
		log.info("Admin 권한 사용자: 댓글 삭제 요청");
	}

	@Before("execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
	public void writeLogForChangeUserRole() {
		log.info("Admin 권한 사용자: 회원 권한 변경 요청");
	}
}
