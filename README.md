# [NEXTSTEP: 2주차] 자동차 경주 게임

---

## Mission 1 : 문자열 덧셈 계산기

### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이
  값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException을 throw한다.

### 기능 목록

- [X] "NULL"값 또는 빈 문자열을 입력할 경우 "0"을 반환한다.
- [X] 숫자 하나를 입력할 경우 해당 숫자를 그대로 반환한다.
- [X] 숫자 사이를 (, 또는 :)로 구분할 경우 두 수의 합을 반환한다.
- [X] "//"와 "\n"사이에 커스텀 구분자를 지정할 수 있다.
- [X] 숫자 이외의 값은 RuntimeException을 Throw한다.
- [X] 지정되지 않은 구분자를 입력할 경우 RuntimeException을 Throw한다.
- [X] 숫자는 새로운 구분자로 들어올 수 없다.

### 다이어그램

![image](https://user-images.githubusercontent.com/58816862/121224459-8aee8f00-c8c3-11eb-8afe-f015361aaafe.png)

---

## Mission 2 : 자동차 경주 게임

### 기능 요구사항

- 각 자동차에 이름을 부여할 수 있다.
- 입력시 자동차의 이름은 (,)로 구분한다.
- 자동차의 이름은 5자를 초과할 수 없다.
- 전진을 시도할 횟수를 입력 받는다.
- 전진하는 자동차를 출력할 때 자동차의 이름을 같이 출력한다.
- 자동차 경주 게임을 완료한 후에 우승자를 알려준다.
- 우승자는 한 명이상일 수 있다.

### 기능 목록

- [X] null 값을 입력하면 NullPointerException을 Throw한다.
- [X] 아무것도 입력하지 않으면 RuntimeException을 Throw한다.
- [X] 혼자 참가하게 되면 자동 우승이 된다.
- [ ] 자동차 이름 (,)로 구분하여 저장한다.
- [ ] 자동차 이름이 5자가 초과되면 RuntimeException을 Throw한다.
- [ ] 전진 시도 횟수가 0일 경우 RuntimeException을 Throw한다.
- [ ] 한 턴에 각 자동차가 전진하는지는 랜덤으로 결정된다.
- [ ] 1등 또는 공동 1등 한 자동차를 반환한다.

---