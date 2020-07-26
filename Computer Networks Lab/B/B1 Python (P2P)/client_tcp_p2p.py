import socket
import sys

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = input('Enter host :')
port = int(input('Enter Port :'))
server_address = (host, port)
print('connecting to {} port {}'.format(*server_address))
sock.connect(server_address)
print("Connected!!")
while True:
   msg = input('You >')
   sock.send(msg.encode('utf8'))
   msg = sock.recv(1024)
   print('Server > {}'.format(msg.decode('utf8')))

sock.close()
