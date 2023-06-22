import { Client } from '@stomp/stompjs';
import { WebSocket } from 'ws';

Object.assign(global, { WebSocket });

function connectCB() {
    console.log("CONNECTED");
}

function errorCB(err) {
    alert(err.header.message);
}

function main() {
    // appears to be working. using server https://github.com/spring-guides/gs-messaging-stomp-websocket
    const client = new Client({
        brokerURL: "ws://localhost:8080/stomp"}
    );
    client.onStompError = (frame) => {
        console.log('Broker reported error: ' + frame.headers['message']);
        console.log('Additional details: ' + frame.body);
      };
      client.onWebSocketError = (ev) => {
        console.log(ev);
      }
      client.onConnect = (frame) => {
        console.log("connected");
        client.subscribe("/topic", (msg) => {
          console.log(msg);
        })
        client.publish({destination: "/app/", body: JSON.stringify({'name': 'hardcoded'})});
      }
      client.activate();
    }

main();