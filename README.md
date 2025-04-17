# 🌱 Spring Common Modules Template

> 실무에서 반복되는 Spring 기반 설정, 응답, 예외 처리, Swagger, 로깅 등을 **공통화**하여  
> 📦 여러 프로젝트에서 빠르게 적용하고 확장할 수 있는 **멀티 모듈 기반 템플릿 프로젝트**입니다.

---

## 📐 프로젝트 목적

- 여러 Spring 프로젝트에서 반복되는 공통 요소를 미리 설정
- **실제 구조와 동일한 멀티 모듈 구성**으로 설계
- 나중에 새로운 프로젝트를 만들 때, 필요한 모듈/기능만 복사 또는 의존성으로 연결 가능
- 공통 설정을 통해 빠르게 개발 시작 가능

---

## 🧱 모듈 구성

```text
spring-common-modules/
├── boot      # 실행 주체 + 공통 설정 (Swagger, 예외, AOP 등)
├── service   # REST 컨트롤러, 서비스 로직, 유틸, 배치
├── store     # DB 접근, 리포지토리
├── domain    # Entity, Enum, Exception, API 응답 구조, 인터페이스 정의
```

---


## ⚙️ 주요 설정

| 항목             | 설명 |
|------------------|------|
| `springdoc-openapi` | Swagger UI + OpenAPI 문서 자동화 구성 |
| `ApiResponse<T>`     | 통일된 성공/실패 응답 구조를 위한 공통 응답 포맷 |
| `BaseException` + `ResultCode` | 에러 코드 기반의 커스텀 예외 처리 체계 |
| AOP 로깅 (`LoggingAspect`) | 모든 API, 배치 실행 시간 및 파라미터 로깅 |
| ContentCachingRequestWrapper | POST 요청의 body 로그 출력 지원 필터 |
| TimeZone 설정 | JVM 전체 타임존을 `Asia/Seoul`로 고정 |
| 멀티모듈 구조 | boot → service → store → domain 순 의존성 구성 |


---

## ✍️ 커밋 컨벤션 (Gitmoji 기반)

본 프로젝트는 커밋 메시지에 [gitmoji](https://gitmoji.dev/) 스타일을 사용합니다.

| 이모지 | 태그 | 설명 |
|--------|------|------|
| ✨ `:sparkles:` | feat | 새로운 기능 추가 |
| 🐛 `:bug:` | fix | 버그 수정 |
| ♻️ `:recycle:` | refactor | 코드 리팩토링 (기능 변화 없음) |
| 🧪 `:test_tube:` | test | 테스트 코드 추가 또는 수정 |
| 📦 `:package:` | chore | 빌드/환경/설정 관련 작업 |
| 📄 `:page_facing_up:` | docs | 문서 추가 또는 수정 (README 등) |
| 🚀 `:rocket:` | deploy | 배포 관련 작업 |
| 🔥 `:fire:` | remove | 불필요한 코드/파일 삭제 |

### gitmoji 커밋을 사용 이유

- ✅ 커밋 히스토리를 한눈에 이해하기 쉽습니다.
- ✅ 협업자 간 커밋 의미 전달이 직관적입니다.
- ✅ GitHub, GitLab 등에서도 이모지가 잘 표시되어 가독성이 좋습니다.