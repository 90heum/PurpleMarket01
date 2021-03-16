package kr.co.heu_um.purplemarket;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {

    ArrayList<MessageItem> messageItems= new ArrayList<>();



    FirebaseDatabase firebaseDatabase;
    DatabaseReference chatRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        //Firebase의 Database 에 저장되어 있는 메세지들 읽어오기
        firebaseDatabase= FirebaseDatabase.getInstance();
        //'chat'노드에 MessageItem들을 저장['chat'이라는 이름만 별도로 지정하면 여러 채팅방 개설도 가능함]
        chatRef= firebaseDatabase.getReference("chat");//
        DatabaseReference purpleChatRef = chatRef.child(G.selectedItem.id + "&" + G.userVo.id);

        purpleChatRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //새로 추가된 데이터값( DataSnapshot이 촬영한 값)
                MessageItem item=snapshot.getValue(MessageItem.class);

                //읽어들인 메세지를 리스트뷰가 보여주는 대량의 데이터에 추가
                messageItems.add(item);

                //리스트뷰 갱신-리스트뷰가 보여줄 뷰를 만들어내는 아답터에게 요청
                chatAdapter.notifyDataSetChanged();
                listView.setSelection(messageItems.size()-1);//리스트뷰의 마지막 위치로 스크롤 이동

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}