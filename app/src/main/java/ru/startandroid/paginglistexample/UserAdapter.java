package ru.startandroid.paginglistexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList = new ArrayList<>();

    class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView surname;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            surname = itemView.findViewById(R.id.tv_surname);
        }

        public void bind(User user) {
            name.setText(user.getName());
            surname.setText(user.getSurname());
        }


    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//создание ViewHolder
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();//размер списка
    }

    public void setItems(Collection<User> users) {//добавление списка
        userList.addAll(users);
        notifyDataSetChanged();
    }


}