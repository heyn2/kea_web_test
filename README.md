# heyeon-name-printer

Spring Boot 애플리케이션으로 `/name` 요청 시 **"이혜연"**을 반환합니다.  
단위 테스트(JUnit 5)와 Jenkins 파이프라인(Jenkinsfile)을 포함합니다.

## 로컬 실행
```bash
./gradlew bootRun
# 또는
./gradlew build
java -jar build/libs/heyeon-name-printer-0.0.1-SNAPSHOT.jar
```

## 엔드포인트
- `GET /name` → `이혜연` 문자열 응답

## 단위 테스트
- `NameServiceTest`: `getMyName()` 검증
- `NameControllerTest`: MockMvc로 `/name` 응답 검증

## Jenkins 파이프라인 개요
- Gradle로 **Compile → Build → Test** 단계 수행 후 JUnit 결과 수집 및 Jar 아카이브
- GitHub Webhook 연동과 기본 파이프라인 구성은 참고 자료의 흐름과 동일합니다. fileciteturn0file0 fileciteturn0file1

## Docker 이미지 빌드
```bash
./gradlew build
docker build -t heyeon/name-printer:local .
docker run --rm -p 8080:8080 heyeon/name-printer:local
```

## 참고
- Gradle/Jenkins 파이프라인 단계(compile/build/test)와 Dockerfile 구조는 제공 자료의 예제를 참고하여 구성했습니다. fileciteturn0file0
- Jenkins 설치, GitHub Webhook, Credentials 설정, 빌드 트리거 구성은 제공 자료의 자동화 절차를 따릅니다. fileciteturn0file1
