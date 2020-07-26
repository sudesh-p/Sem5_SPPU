import java.util.Scanner;		//for input


/*Read the theory for subnetting at the end of the document!!! OH YES,LOGIC KA HAI BAS,PEHLE THEORY SAMJHO, CODING EASY HAI ISKA AS NO UNFAMILIAR FUNCTIONS USAGE!

ALGORITHM:
1.Take a input as a IP address as a string.
2.Split the string after every .
3.Convert string to integer,integer to binary and append 0 to make it 8 bit binary number.
4.Take a input of number of addresses.
5.Calculation of mask using ceil and log functions.
int bits = (int)Math.ceil(Math.log(n)/Math.log(2));
mask = 32-bits;
6.convert character 0,1 to integer 0,1 and Get first address by ANDing last n bits with 0.
7.Convert that binary number into decimal number by dividing by 8.
8.Get last address by ORing last n bits with 1 and convert it into decimal number.

*/

class Subnet
{
   public static void main(String args[])
   {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the ip address: ");
	String ip = sc.nextLine();
	String split_ip[] = ip.split("\\."); 	//Split the string after every period(.)(Don't forget to put the escape sequence (\\) in the string as java compiler needs to recognize a special character is incoming!)
	String split_bip[] = new String[4]; 	//split binary ip
	String bip = "";
	for(int i=0;i<4;i++)	//every number is converted into octet
	{
		split_bip[i] = appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i]))); // "18" => 18 => 10010 => 00010010
		bip += split_bip[i];		//and then joining again so as to display the the 32 bit ip
	}
	System.out.println("IP in binary is: "+bip);
	System.out.print("Enter the number of addresses per subnet: ");		//number of addresses required
	int n = sc.nextInt();

	//Calculation of mask
	//refer the theory,required!
	int bits = (int)Math.ceil(Math.log(n)/Math.log(2)); /*eg if addresses required = 120, log 120/log 2 gives log to the base 2 => 6.9068, ceil gives us upper integer */
	System.out.println("Number of bits required for address: = "+bits);
	int mask = 32-bits;		//subnet mask will be dependent on the remaining bits
	System.out.print("The subnet mask is: = ");
	//i have printed it right away,if you want store it in some array first and then print it...
	for (int i=0;i<32;i++)
	{
		if(i<mask)
			System.out.print("1");
		else
			System.out.print("0");
		if((i+1)%8==0 && i!=31)
		{
			System.out.print(".");
		}
	}
	System.out.println();

	//Calculation of first address and last address
	int fbip[] = new int[32];
	for(int i=0; i<32;i++)
		fbip[i] = (int)bip.charAt(i)-48; //convert character 0,1 to integer 0,1
	//ASCII value of 0 is 48 and hence we subtract 48 from ascii value

	for(int i=31;i>31-bits;i--)//Get first address by ANDing last bits with 0
		fbip[i] &= 0;

	
	//Binary to decimal conversion
	String fip[] ={"","","",""};
	for(int i=0;i<32;i++)
		fip[i/8] = new String(fip[i/8]+fbip[i]); 
	/* for i=0 to i=8,i/8 will be 0, so the result whatever it is (can be 0 or 1 depending on fbip), will be stored in fip[0];
	 * ;;
	 * ;;
	 * for i<bits,we had already set those to 0,so those bits will be zero in the first address.
	 * 
	 */
	
	System.out.print("Subnet address is = ");
	
	for(int i=0;i<4;i++)
	{
		System.out.print(Integer.parseInt(fip[i],2));	//parseInt has two args,first is the string being passed,second is the number system of the same(by default it is decimal,hence we dont use the second aregument until it is required)
		if(i!=3)
		 System.out.print(".");
	}

	//for last address/broadcast address
	int lbip[] = new int[32];	
	for(int i=0; i<32;i++)
		lbip[i] = (int)bip.charAt(i)-48; //convert character 0,1 to integer 0,1
	
	for(int i=31;i>31-bits;i--)//Get last address by ORing last n bits with 1
		lbip[i] |= 1;
	
	//Binary to decimal conversion
	String lip[] = {"","","",""};
	for(int i=0;i<32;i++)
		lip[i/8] = new String(lip[i/8]+lbip[i]);
	/* for i=0 to i=8,i/8 will be 0,
	 *  so the result whatever it is (can be 0 or 1 depending on lbip), will be stored in lip[0];
	Similarly for all the values of i

*/
	System.out.println();

	System.out.print("Broadcast address is = ");
	
	for(int i=0;i<4;i++)
	{
		System.out.print(Integer.parseInt(lip[i],2));
		if(i!=3) System.out.print(".");
	}
		System.out.println();
		sc.close();
    }
	static String appendZeros(String s)		//used to append zeros(padding) in order to make an octet
	{
		String temp = new String("00000000");
		return temp.substring(s.length())+ s;
	}
}


/*OUTPUT
 * 
 * Enter the ip address: 192.168.10.44
IP in binary is: 11000000101010000000101000101100
Enter the number of addresses per subnet: 32
Number of bits required for address: = 5
The subnet mask is: = 11111111.11111111.11111111.11100000
Subnet address is = 192.168.10.32
Broadcast address is = 192.168.10.63


 */


/*
 * THEORY :
Address -
The unique number ID assigned to one host or interface in a network.
Subnet mask -
A 32-bit combination used to describe which portion of an address refers to the subnet and
which part refers to the host
IP Addresses:-
An IP address is an address used in order to uniquely identify a device on an IP
network. The address is made up of 32 binary bits, which can be divisible into a network
portion and host portion with the help of a subnet mask. The 32 binary bits are broken
into four octets (1 octet = 8 bits).
Each octet is converted to decimal and separated by a period (dot). For this reason,
an IP address is said to be expressed in dotted decimal format (for example,
172.16.81.100). The value in each octet ranges from 0 to 255 decimal, or 00000000 -
11111111 binary.

Network Masks
A network mask helps you know which portion of the address identifies the network
and which portion of the address identifies the node. Class A, B, and C networks have
default masks, also known as natural masks, as shown here:
Class A: 255.0.0.0
Class B: 255.255.0.0
Class C: 255.255.255.0
An IP address on a Class A network that has not been subnetted would
have an address/mask pair similar to: 8.20.15.1 255.0.0.0. In order to see how the mask
helps you identify the network and node parts of the address, convert the address and
mask to binary numbers.
8.20.15.1 = 00001000.00010100.00001111.00000001
255.0.0.0 = 11111111.00000000.00000000.00000000
Once you have the address and the mask represented in binary, then identification of
the network and host ID is easier. Any address bits which have corresponding mask bits set
to 1 represent the network ID. Any address bits that have corresponding mask bits
set to 0 represent the node ID.
8.20.15.1 = 00001000.00010100.00001111.00000001
255.0.0.0 = 11111111.00000000.00000000.00000000
-----------------------------------
net id | host id
netid = 00001000 = 8
hostid = 00010100.00001111.00000001 = 20.15.1

Subnet :
A portion of a network that shares a particular subnet address. Each data link on a
network must have a unique network ID, with every node on that link being a member of
the same network. If you break a major network (Class A, B, or C) into smaller
subnetworks, it allows you to create a network of interconnecting subnetworks. Each data
link on this network would then have a unique network/subnetwork ID. Any device, or
gateway, that connects n networks/subnetworks has n distinct IP addresses, one
for each network / subnetwork that it interconnects.

In order to subnet a network, extend the natural mask with some of the bits from the
host ID portion of the address in order to create a subnetwork ID. For example, given a
Class C network of 204.17.5.0 which has a natural mask of 255.255.255.0, you can create
subnets in this manner:

204.17.5.0 - 11001100.00010001.00000101.00000000
255.255.255.224 - 11111111.11111111.11111111.11100000
--------------------------|sub|----

By extending the mask to be 255.255.255.224, you have taken three bits
(indicated by "sub") from the original host portion of the address and used them to make
subnets. With these three bits, it is possible to create eight subnets. With the remaining five
host ID bits, each subnet can have up to 32 host addresses, 30 of which can actually be
assigned to a device since host ids of all zeros or all ones are not allowed (it is very
important to remember this). So, with this in mind, these subnets have been created.

204.17.5.0 255.255.255.224 host address range 1 to 30
204.17.5.32 255.255.255.224 host address range 33 to 62
204.17.5.64 255.255.255.224 host address range 65 to 94
204.17.5.96 255.255.255.224 host address range 97 to 126
204.17.5.128 255.255.255.224 host address range 129 to 158
204.17.5.160 255.255.255.224 host address range 161 to 19
204.17.5.192 255.255.255.224 host address range 193 to 222
204.17.5.224 255.255.255.224 host address range 225 to 254


*/
