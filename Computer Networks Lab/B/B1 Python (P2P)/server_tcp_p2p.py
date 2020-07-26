import socket
import sys
from random import randint

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = '127.0.0.1'
port = randint(1024,9999)
server_address = (host, port)
print('starting up on {} port {}'.format(*server_address))
sock.bind(server_address)

print('waiting for a connection')
sock.listen(1)
connection, client_address = sock.accept()
print('connection from', client_address)

while True:
    msg = connection.recv(1024)
    print('Client > {}'.format(msg.decode('utf8')))
    msg = input("You >")
    connection.send(msg.encode('utf8'))

connection.close()
