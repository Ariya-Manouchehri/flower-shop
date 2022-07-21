package com.example.flowershop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flowershop.Comment;
import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.CommentsViewAdapter;

import java.util.ArrayList;

public class CommentsFragment extends Fragment {
RecyclerView commentsRecyclerview;
CommentsViewAdapter commentsViewAdapter;
ArrayList<Comment> comments = new ArrayList<>();

    public CommentsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comments.add(new Comment("sara","not good not bad",3));
        comments.add(new Comment("amir","References to the algorithm implemented (web page, academic article, etc.). If the code is adapted from another version or language, put the link to that previous version. Basically put non-trivial code within context in order to avoid you or another to guess.",4));
        comments.add(new Comment("ariya","As you work with code for a while, I'd say neither is better or worse. Not enough can lead to confusing code while too much still lead to people not even reading it",3));
        comments.add(new Comment("reza","So for now, if you're new, it might be better to comment a bit more so people can catch your \"WTFs\" earlier rather than later, but as you work longer, it should veer towards less unless you're working with very generic code/libraries that require a lot of pre/post conditions and usage examples.",2));
        comments.add(new Comment("mobina","Its always a good Idea to comment your code. It doesnt really matter if you have a lot of a little. The most important thing is that they are clear and to the point.",3.5f));
        comments.add(new Comment("ashkan","you will need to write informative comments to let other people know what you are trying to accomplish with that code block or class",5));
        comments.add(new Comment("shaghyegh","No comments” means “do not write comments”, as in some writers do not allow comments on their Quora answers. Like me.",4.2f));
        comments.add(new Comment("farhad","This does not mean that people, including myself, don’t examine and evaluate and change their opinions. But it means that angry trolls and people who feel their unsolicited opinion must be heard are not people that will help my opinions grow and change.",2.5f));
        comments.add(new Comment("mohsen","They write a giant 4500-word single paragraph wall of text. It’s usually a rant with no commas or periods separating any of the thoughts. The wall is bewildering",3));
        comments.add(new Comment("maryam","If I’m in a good mood, I’ll respond and offer to read a condensed version if they send me the cliff notes. Otherwise, I just don’t have the time.",5));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        commentsRecyclerview = view.findViewById(R.id.commentsRecyclerview);

        commentsViewAdapter = new CommentsViewAdapter(comments,getContext());
        commentsRecyclerview.setAdapter(commentsViewAdapter);

        commentsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}