package com.mind.simplelogin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class PDFAdapter extends ArrayAdapter<File> {
    Context context;
    ViewHolder viewHolder;
    ArrayList<File> al_pdf;

    public PDFAdapter(Context context, ArrayList<File> al_pdf) {
        super(context, R.layout.adapter_pdf, al_pdf);
        this.context = context;
        this.al_pdf = al_pdf;

    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        if (al_pdf.size() > 0) {
            return al_pdf.size();
        } else {
            return 1;
        }
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_pdf, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_filename = (TextView) view.findViewById(R.id.tv_name);
            viewHolder.ivshare=view.findViewById(R.id.ivshare);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.tv_filename.setText(al_pdf.get(position).getName());
        viewHolder.ivshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationInfo applicationInfo=context.getApplicationInfo();
                String apkpath=applicationInfo.sourceDir;
                File file=new File(apkpath);
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("application/pdf");
                intent.putExtra(Intent.EXTRA_TEXT,"message");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                context.startActivity(Intent.createChooser(intent,"share via"));
            }
        });
        return view;

    }

    public class ViewHolder {

        TextView tv_filename;
        ImageView ivshare;
    }

}