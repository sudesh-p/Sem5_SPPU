import socket
import sys

# Create a UDP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_address = ('localhost', 10000)
message = "client connected"
sent = sock.sendto(message.encode("utf-8"), server_address)
print('waiting to receive')
while True:
   
   msg, server = sock.recvfrom(4096)
   print("Server:   ",msg.decode('utf-8'))
   msg = input("YOU:     ")
   if "exit-chat" in msg:
      break
   sent = sock.sendto(msg.encode('utf-8'), server_address)

sock.close()
