package ru.startandroid.paginglistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    ArrayList<User> userList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
    }


    private void createUsers()  {

         for (int i = 1; i<=20; i++){
                       userList.add( new User("name" + i, "surname" + i));
        }

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);
        createUsers();
        adapter.setItems(userList);
        recyclerView.addOnScrollListener(new PaginationListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                adapter.setItems(userList);
            }
        });
    }
    }
