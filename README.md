# MapleStory Weekly Boss Checker

메이플스토리 주간 보스 체커

## 버전

Version 1.0.0

## 설명

### 1. 메이플스토리 여름 시즌을 맞아 주간 보스 클리어 여부를 기록하는 안드로이드 애플리케이션 제작

### 2. 제작자의 본 계정 기준 솔로 플레이가 가능한 보스들(과 이론상 가능한 보스들)을 기준으로 제작되었으며, 그 내역은 다음과 같다.

- 내역
    - 하드 힐라
    - 카오스 핑크빈
    - 노멀 시그너스
    - 카오스 자쿰
    ---
    - 카오스 블러디퀸
    - 카오스 반반
    - 카오스 피에르
    ---
    - 하드 매그너스
    - 카오스 벨룸
    - 카오스 파풀라투스
    ---
    - 노멀 스우
    - 노멀 데미안
    ---
    - 노멀 가디언 엔젤 슬라임
    - 이지 루시드
    - 이지 윌

### 3. 클리어한 보스를 선택하면 이번주에 획득한 결정석 메소량을 확인할 수 있으며, 매주 목요일 자정(0시)에 초기화된다.

#### WorkManager는 잠시 비활성화했으며, 초기화 버튼을 통해 직접 클리어 내역을 초기화 할 수 있다.

## 목표

1. `Kotlin` 언어 학습
    - **Kotlin + Spring** 대비
2. `Android Application` 제작
    - **메이플스토리** 시즌 맞이
    - **Learning by doing** 및 최소 기능 구현

## 기술 스택

- Kotlin
- Android
- Android Studio

## 구현 내용

1. 단일 페이지 UI 구성
2. 버튼을 누르면 `버튼 비활성화`, `메소 계산`, `갱신된 메소 출력`
3. 매주 목요일 자정에 `버튼 활성화`, `메소 초기화`
    - 안드로이드의 `WorkManager`를 사용하여 주기적으로 실행되는 작업 정의
4. 앱을 꺼도 정보가 유지되도록 함 - `캐시`

## 얻은 점

1. 코틀린 문법에 대한 이해
2. 안드로이드 애플리케이션 생명 주기에 대한 이해
