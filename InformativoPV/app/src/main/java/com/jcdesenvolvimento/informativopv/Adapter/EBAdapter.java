package com.jcdesenvolvimento.informativopv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcdesenvolvimento.informativopv.Model.Escala;
import com.jcdesenvolvimento.informativopv.R;

import java.util.List;

/**
 * Created by joni on 17/12/2017.
 */

public class EBAdapter extends RecyclerView.Adapter<EBAdapter.EBViewHolder> {

    private List<Escala> mEscalas;
    private LayoutInflater mLayoutInflate;

    public EBAdapter(Context c, List<Escala> escalas) {
        mEscalas = escalas;
        mLayoutInflate = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Chamado somente ao criar a view
    @Override
    public EBViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflate.inflate(R.layout.layout_lista_escala_eb, parent, false);
        EBViewHolder EBVH = new EBViewHolder(v);
        return EBVH;
    }


    @Override
    public void onBindViewHolder(EBViewHolder holder, int position) {

        holder.tvCoodenacaoEB.setText(mEscalas.get(position).getsCoordenador_EB().toString());
        holder.tvSecretariaEB.setText(mEscalas.get(position).getsSecretario_EB().toString());
        holder.tvProfessorEB.setText(mEscalas.get(position).getsProfessor_EB().toString());
        holder.tvOfertaEB.setText(mEscalas.get(position).getsOferta().toString());

    }

    @Override
    public int getItemCount() {
        return mEscalas.size();
    }


    //Implemetaçãoda classe holder para controle das Views
    public class EBViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCoodenacaoEB;
        public TextView tvSecretariaEB;
        public TextView tvProfessorEB;
        public TextView tvOfertaEB;

        public EBViewHolder(View itemView) {
            super(itemView);
            tvCoodenacaoEB = (TextView) itemView.findViewById(R.id.tv_direcao_eb);
            tvSecretariaEB = (TextView) itemView.findViewById(R.id.tv_secretaria_eb);
            tvOfertaEB = (TextView) itemView.findViewById(R.id.tv_oferta_eb);
            tvProfessorEB = (TextView) itemView.findViewById(R.id.tv_professor_eb);

        }


    }

}




