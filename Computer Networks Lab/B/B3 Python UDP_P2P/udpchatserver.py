import socket
import sys

# Create a UDP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Bind the socket to the port
server_address = ('localhost', 10000)
print('starting up on {} port {}'.format(*server_address))
sock.bind(server_address)

print('\nwaiting to receive message')

while True:
   
   msg, address = sock.recvfrom(4096)
   print("Client:   ",msg.decode('utf-8')) 
   msg = input("You:     ")
   if "exit-chat" in msg:
      break
   sent = sock.sendto(msg.encode('utf-8'), address)

sock.close()

