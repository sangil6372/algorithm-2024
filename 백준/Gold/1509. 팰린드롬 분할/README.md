# [Gold I] 팰린드롬 분할 - 1509 

[문제 링크](https://www.acmicpc.net/problem/1509) 

### 성능 요약

메모리: 22372 KB, 시간: 268 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2024년 1월 15일 23:40:24

### 문제 설명

<p>세준이는 어떤 문자열을 팰린드롬으로 분할하려고 한다. 예를 들어, ABACABA를 팰린드롬으로 분할하면, {A, B, A, C, A, B, A}, {A, BACAB, A}, {ABA, C, ABA}, {ABACABA}등이 있다.</p>

<p>분할의 개수의 최솟값을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 문자열이 주어진다. 이 문자열은 알파벳 대문자로만 이루어져 있고, 최대 길이는 2,500이다.</p>

### 출력 

 <p>첫째 줄에 팰린드롬 분할의 개수의 최솟값을 출력한다.</p>

## 알게된 점
 1. 팰린드롬 체크 함수를 만들었었는데 메모리 초과가 발생하였다. 체크 함수를 만드는 과정에서도 DP를 적용하면 코드가 간결해진다.
 2. 메모이제이션에서 i와 j의 위치가 헷갈린다. DP에서 일반적인 루틴이니 숙지하도록 하자.

    for (int end = 0; end < len; end++) {
                for (int start = 0; start <= end; start++) {
                    if (str.charAt(start) == str.charAt(end) && (end - start < 2 || isPalindrome[start + 1][end - 1])) {
                        isPalindrome[start][end] = true;
                    }
                }
            }            

    for (int i = 1; i <= len; i++) {
                dp[i] = Integer.MAX_VALUE; // 일단 초기값 (최소값으로 갱신)
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j][i - 1]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
