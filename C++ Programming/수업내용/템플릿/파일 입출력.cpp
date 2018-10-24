#include <iostream>
#include <fstream>
using namespace std;

void main()
{
	char buf[] = "superman";

	ofstream fout; // 파일 출력 객체
	fout.open("b.txt"); // 파일 오픈
	fout << buf; // 파일에 데이터 출력
	fout.close(); // 파일 닫기

	/*
	char buf1[30];

	ifstream fin; // 파일 출력 객체

	fin.open("b.txt"); // 파일 오픈

	fin >> buf1;

	fin.close(); // 파일 닫기
	*/


}
