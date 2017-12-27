package com.jcdesenvolvimento.informativopv.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcdesenvolvimento.informativopv.Adapter.InformativoAdapter;
import com.jcdesenvolvimento.informativopv.Bd.BD;
import com.jcdesenvolvimento.informativopv.Bd.CRUD;
import com.jcdesenvolvimento.informativopv.Model.Boletim;
import com.jcdesenvolvimento.informativopv.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaInformativoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaInformativoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaInformativoFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private InformativoAdapter informativoAdapterdapter;
    private List<Boletim> listainformativos;
    private CRUD crud;
    private RecyclerView rvInformativos;

    public ListaInformativoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaInformativoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaInformativoFragment newInstance(String param1, String param2) {
        ListaInformativoFragment fragment = new ListaInformativoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_informativo, container, false);

        crud = new CRUD(getContext());
        listainformativos = crud.buscarBoletim();

        rvInformativos = (RecyclerView) v.findViewById(R.id.rv_lista_informativos);
        rvInformativos.setHasFixedSize(true);

        GridLayoutManager GLM = new GridLayoutManager(getContext(),2);
        GLM.setOrientation(GridLayoutManager.HORIZONTAL);

        informativoAdapterdapter = new InformativoAdapter(getContext(),listainformativos);
        rvInformativos.setAdapter(informativoAdapterdapter);
        rvInformativos.setLayoutManager(GLM);


        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        // Inflate the layout for this fragment
        return v;

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                mudaFragment();
                break;
        }

    }

    public void mudaFragment(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        InformativoFragment informativoFragment = new InformativoFragment();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container_fragment,  informativoFragment);
        ft.commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
