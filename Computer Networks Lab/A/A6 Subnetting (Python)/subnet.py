
import sys
addr = [0, 0, 0, 0]
mask = [0, 0, 0, 0]
cidr = 0
			
if len(sys.argv) == 2:
	(addr, cidr) = sys.argv[1].split('/')
	addr = [int(x) for x in addr.split(".")]
	cidr = int(cidr)
	mask = [( ((1<<32)-1) << (32-cidr) >> i ) & 255 for i in reversed(range(0, 32, 8))]
	
else:
	print("Use: {0} <ip/cidr>".format(sys.argv[0]))
	sys.exit(-1)

netw = [addr[i] & mask[i] for i in range(4)]
bcas = [(addr[i] & mask[i]) | (255^mask[i]) for i in range(4)]	

if addr[0] >= 1 and addr[0] <= 126:
   print("Class A")
elif addr[0] >= 128 and addr[0] <= 197 :
   print("Class B")
elif addr[0] >= 192 and addr[0] <= 223 :
   print("Class C")
elif addr[0] >= 224 and addr[0] <= 239 :
   print("Class D")
elif addr[0] >= 240 and addr[0] <= 255 :
   print("Class E")


print("Address: {0}".format('.'.join(map(str, addr))))
print("Mask: {0}".format('.'.join(map(str, mask))))
print("Cidr: {0}".format(cidr))
print("Network: {0}".format('.'.join(map(str, netw))))
print("Broadcast: {0}".format('.'.join(map(str, bcas))))
