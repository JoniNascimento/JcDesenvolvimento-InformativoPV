package com.jcdesenvolvimento.informativopv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcdesenvolvimento.informativopv.Model.Boletim;
import com.jcdesenvolvimento.informativopv.Model.Escala;
import com.jcdesenvolvimento.informativopv.R;
import com.jcdesenvolvimento.informativopv.Util.Functions;

import java.util.List;

/**
 * Created by joni on 17/12/2017.
 */

public class EscalaAdapter extends RecyclerView.Adapter<EscalaAdapter.EscalaViewHolder>  implements View.OnClickListener{

    private List<Escala> mEscalas;
    private LayoutInflater mLayoutInflate;

    public EscalaAdapter(Context c, List<Escala> escalas) {
        mEscalas = escalas;
        mLayoutInflate = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Chamado somente ao criar a view
    @Override
    public EscalaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflate.inflate(R.layout.layout_lista_escala_oficial, parent, false);
        EscalaViewHolder EVH = new EscalaViewHolder(v);
        return EVH;
    }


    @Override
    public void onBindViewHolder(EscalaViewHolder holder, int position) {

        holder.tvDirecaoCulto.setText(mEscalas.get(position).getsDiretor().toString());
        holder.tvMensagemCulto.setText(mEscalas.get(position).getsPregador().toString());
        holder.tvLouvorCulto.setText(mEscalas.get(position).getsLouvor().toString());
        holder.tvOfertaCulto.setText(mEscalas.get(position).getsOferta().toString());

        //manipular o click dos Text Views
        holder.tvDirecaoCulto.setOnClickListener(this);
        holder.tvMensagemCulto.setOnClickListener(this);
        holder.tvLouvorCulto.setOnClickListener(this);
        holder.tvOfertaCulto.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mEscalas.size();
    }

    @Override
    public void onClick(View v) {
        //abrir o Alert dialog com os nomes dos membros que vem do banco para inserir no objeto da escala


    }


    //Implemetaçãoda classe holder para controle das Views
    public class EscalaViewHolder extends RecyclerView.ViewHolder {

        public TextView tvDirecaoCulto;
        public TextView tvMensagemCulto;
        public TextView tvLouvorCulto;
        public TextView tvOfertaCulto;

        public EscalaViewHolder(View itemView) {
            super(itemView);
            tvDirecaoCulto = (TextView) itemView.findViewById(R.id.tv_direcao_culto);
            tvMensagemCulto = (TextView) itemView.findViewById(R.id.tv_mensagem_culto);
            tvLouvorCulto = (TextView) itemView.findViewById(R.id.tv_louvor_culto);
            tvOfertaCulto = (TextView) itemView.findViewById(R.id.tv_oferta_culto);



        }


    }

}




