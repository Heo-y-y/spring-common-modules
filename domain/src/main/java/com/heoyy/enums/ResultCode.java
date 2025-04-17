package com.heoyy.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Response Code
 */
@Getter
@RequiredArgsConstructor
public enum ResultCode {

    RC200(200, "OK", "성공"),
    RC201(201, "No Data", "검색 결과 없음"),
    RC202(200, "Login Success", "로그인 성공"),
    RC400(400, "Bad Request", "요청 실패"),
    RC401(401, "Login Failed", "로그인 실패"),
    RC401_1(401, "Not Valid Token", "유효하지 않은 토큰입니다."),
    RC404(404, "Not Found", "존재하지 않는 엔티티"),
    RC405(405, "Method Not Allowed", "잘못된 Http Method"),
    RC408(408, "Request Timeout", "요청 응답 없음"),
    RC409(409, "Conflict", "요청 상태와 현재 상태가 동일하여 변경할 수 없습니다"),
    RC420(420, "Mandatory Param Error", "필수 파라미터 오류"),
    RC421(421, "Invalid Param Error", "지원하지 않는 파라미터"),
    RC422(400, "Mandatory Header Error", "필수 헤더 미입력"),
    RC430(430, "Query Failed", "조회 실패"),
    RC431(431, "Registration Failed", "등록 실패"),
    RC432(432, "Generation Failed", "생성 실패"),
    RC433(433, "Modification Failed", "수정 실패"),
    RC434(434, "Removal Failed", "삭제 실패"),
    RC500(500, "Internal Server Error", "서버 내부 오류");

    private final int code;
    private final String systemMsg;
    private final String userMsg;
}

