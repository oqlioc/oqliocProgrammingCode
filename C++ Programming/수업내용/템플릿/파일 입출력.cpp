#include <iostream>
#include <fstream>
using namespace std;

void main()
{
	char buf[] = "superman";

	ofstream fout; // ���� ��� ��ü
	fout.open("b.txt"); // ���� ����
	fout << buf; // ���Ͽ� ������ ���
	fout.close(); // ���� �ݱ�

	/*
	char buf1[30];

	ifstream fin; // ���� ��� ��ü

	fin.open("b.txt"); // ���� ����

	fin >> buf1;

	fin.close(); // ���� �ݱ�
	*/


}
