package ru.startandroid.paginglistexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class PaginationListener extends RecyclerView.OnScrollListener {

    private LinearLayoutManager layoutManager;

    private int visibleItemCount, totalItemCount, firstVisibleItemPosition;

    protected PaginationListener(@NonNull LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy > 0)
        {
            visibleItemCount = layoutManager.getChildCount();
            totalItemCount = layoutManager.getItemCount();
            firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();



            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                loadMoreItems();
            }
        }
    }
    protected abstract void loadMoreItems();
}
