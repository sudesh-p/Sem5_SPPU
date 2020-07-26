#include<iostream>
#include <fstream>
#include <iomanip>
#include <string>
using namespace std;

int main(int argc, char const *argv[])
{
	cout<<"\nPACKET ANALYZER\n";
	int count,i,choice;

	string no,time,source,destination,protocol,length,info;
	string protocolChoice;

	do{
		ifstream file("a7.csv");
		count = -1;
		i=0;
		cout<<"\nEnter which protocol packets you want to see"<<endl;
		cout<<"1.IP\n2.UDP\n3.TCP\n4.Ethernet\n0Exit!!!\nChoice:"<<endl;
		cin>>choice;

		switch(choice){
			case 1: protocolChoice="\"ICMPv6\"";
			break;
			case 2: protocolChoice="\"UDP\"";
			break;
			case 3: protocolChoice="\"TCP\"";
			break;
			case 4: protocolChoice="\"ARP\"";
			break;
			default: protocolChoice="\"ARP\"";
			break;

		}

		while(file.good()){
			getline(file,no,',');
			getline(file,time,',');
			getline(file,source,',');
			getline(file,destination,',');
			getline(file,protocol,',');
			getline(file,length,',');
			getline(file,info,'\n');

			if(protocol == protocolChoice || protocol == "Protocol"){
				cout<<setw(4)<<left<<i++;
				cout<<setw(12)<<left<<string(time,1,time.length()-2);
				cout<<setw(30)<<left<<string(source,1,source.length()-2);
				cout<<setw(30)<<left<<string(destination,1,destination.length()-2);
				cout<<setw(8)<<left<<string(protocol,1,protocol.length()-2);
				cout<<setw(8)<<left<<string(length,1,length.length()-2);
				cout<<string(info,1,info.length()-2);
				cout<<endl;
				count++;				
			}
		}
		file.close();
		cout<<"\nCount:"<<count<<endl;
	}while(choice!=0);
	return 0;
}