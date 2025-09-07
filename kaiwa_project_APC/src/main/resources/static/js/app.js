let stompClient = null;
let currentRoom = null;

function setConnected(connected) {
    document.getElementById('connectBtn').disabled = connected;
    document.getElementById('disconnectBtn').disabled = !connected;
    document.getElementById('sendBtn').disabled = !connected;
    document.getElementById('status').innerText = connected ? "Connected" : "Disconnected";
}

document.getElementById('connectBtn').addEventListener('click', () => {
    const roomId = document.getElementById('roomId').value.trim();
    if (!roomId) return;
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        currentRoom = roomId;
        stompClient.subscribe('/topic/' + roomId, function (message) {
            const payload = JSON.parse(message.body);
            const li = document.createElement('li');
            li.textContent = payload.timestamp + ' [' + payload.sender + ']: ' + payload.content;
            document.getElementById('messages').appendChild(li);
        });
    });
});

document.getElementById('disconnectBtn').addEventListener('click', () => {
    if (stompClient !== null) {
        stompClient.disconnect(() => setConnected(false));
    }
});

document.getElementById('sendBtn').addEventListener('click', () => {
    const msg = document.getElementById('message').value;
    if (!msg || !stompClient || !currentRoom) return;
    stompClient.send('/app/chat/' + currentRoom, {}, JSON.stringify({
        content: msg,
        sender: 'me'
    }));
    document.getElementById('message').value = '';
});


