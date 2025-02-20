/*
하노이 탑 이동 순서

첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.

첫째 줄에 옮긴 횟수 K를 출력한다.
두 번째 줄부터 수행 과정을 출력한다.
두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,
이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
*/

#include <iostream>
#include <cmath>

void hanoi(int height, int from, int by, int to);

int main(void){
  int height = 0;

  //타워의 높이 즉 원판의 갯수를 입력
  std::cin >> height;
  //총 이동 수는 2^N-1이다. 이 수는 메르센 소수라고도 부른다.
  //인풋이 2^20까지 가능하므로 unsigned int 또는 long을 사용하여 출력한다.
  printf("%u\n",  (unsigned int)(pow(2, height) - 1));
  //원판을 이동시키는 경로를 출력하는 함수를 부른다.
  //각 파라미터는 높이, 현재 기둥 위치, 경유하는 기둥위치, 최종 목적 기둥위치이다.
  hanoi(height, 1, 2, 3);
  return 0;
}

void hanoi(int height, int from, int by, int to)
{
  if (0 == height)
  {
    //높이가 0이면 옮길 수 없으므로 반환한다.
    return;
  }
  else
  {
    //n-1개의 원판을 현재 기둥에서 경유하는 기둥으로 옮긴다.
    hanoi(height - 1, from, to, by);
    //가장 큰 원판을 현재 위치에서 목표하는 위치의 기둥으로 옮긴다.
    printf("%d %d\n", from, to);
    //경유하는 기둥에 옮겨 놓았던 n-1개의 원판을 목표하는 위치의 기둥으로 옮긴다.
    hanoi(height - 1, by, from, to);
  }
}