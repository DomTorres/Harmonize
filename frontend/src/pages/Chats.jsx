import React from 'react'
import { over } from 'stompjs'
import SockJS from 'sockjs-client'

let stompClient = null;

const Chats = () => {
    const [userData, setUserData] = useState({
        username: '',
        reciever: '',
        connected: false,
        message: ''
    })

    const [privateChats, setPrivateChats] = useState(new Map());

    const handleUsername = (event) => {
        const { value } = event.target;
        setUserData({...userData, 'username' : value});
    } 

    const registerUser = () => {
        let sock = new SockJS('http://localhost:8080/ws');
        stompClient = over(sock);
        stompClient.connect({}, onConnected, onError);
    }

    const onConnected = () => {
        setUserData({...userData, 'connected' : true});
        stompClient.subscribe('/user/' + userData.username + '/chat', onPrivateMessageReceived);
    }

    const onPrivateMessageReceived = (payload) => {
        let payloadData = JSON.parse(payload.body);
        let senderUsername = payloadData.sender.getUsername();

        if (privateChats.get(senderUsername)) {
            privateChats.get(senderUsername).push(payloadData);
        } else {
            let list = [];
            list.push(payloadData);
            privateChats.set(senderUsername, list);
        }

        setPrivateChats(new Map(privateChats));
    }

    const onError = (error) => {
        console.log(error);
    }

    return (
        <div className='container'>
            {userData.connected ? 
                <div className='chat-box'>
                    <div className='member-list'>
                        <ul>
                            <li>Chatroom</li>
                            {[...privateChats.keys()].map((name, index) => (
                                <li className='member' key={index}>
                                    {name}
                                </li>
                            ))}
                        </ul>
                    </div>
                </div>
            :
                <div className='register'>
                    <input
                    id='username'
                    placeholder='Enter username' 
                    value={userData.username}
                    onChange={handleUsername}
                    />
                    <button type='button' onClick={registerUser}>
                        Connect
                    </button>
                </div>
            }
        </div>
    )
}

export default Chats
