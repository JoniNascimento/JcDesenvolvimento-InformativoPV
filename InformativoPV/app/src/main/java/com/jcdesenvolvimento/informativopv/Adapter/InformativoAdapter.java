package com.jcdesenvolvimento.informativopv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcdesenvolvimento.informativopv.Model.Boletim;
import com.jcdesenvolvimento.informativopv.R;
import com.jcdesenvolvimento.informativopv.Util.Functions;


import java.util.List;

/**
 * Created by joni on 17/12/2017.
 */

public class InformativoAdapter extends RecyclerView.Adapter<InformativoAdapter.InformativoViewHolder> {

    private List<Boletim> mInformativos;
    private LayoutInflater mLayoutInflate;

    public InformativoAdapter(Context c, List<Boletim> informativos) {
        mInformativos = informativos;
        mLayoutInflate = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Chamado somente ao criar a view
    @Override
    public InformativoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflate.inflate(R.layout.layout_lista_boletim, parent, false);
        InformativoViewHolder IVH = new InformativoViewHolder(v);
        return IVH;
    }


    @Override
    public void onBindViewHolder(InformativoViewHolder holder, int position) {
        Functions functions = new Functions();

        holder.imgInformativo.setImageBitmap(functions.byteToBitmap(mInformativos.get(position).getiImagem()));
        holder.tvTittulo.setText(mInformativos.get(position).getTitulo().toString());

    }

    @Override
    public int getItemCount() {
        return mInformativos.size();
    }


    //Implemetaçãoda classe holder para controle das Views
    public class InformativoViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgInformativo;
        public TextView tvTittulo;

        public InformativoViewHolder(View itemView) {
            super(itemView);
            imgInformativo = (ImageView) itemView.findViewById(R.id.imgBoletim);
            tvTittulo = (TextView) itemView.findViewById(R.id.tv_titulo_informativo);

        }


    }

}




