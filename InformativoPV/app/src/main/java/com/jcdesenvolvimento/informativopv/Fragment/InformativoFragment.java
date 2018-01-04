package com.jcdesenvolvimento.informativopv.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.jcdesenvolvimento.informativopv.Bd.CRUD;
import com.jcdesenvolvimento.informativopv.Model.Boletim;
import com.jcdesenvolvimento.informativopv.R;
import com.jcdesenvolvimento.informativopv.Util.Constants;
import com.jcdesenvolvimento.informativopv.Util.Functions;
import com.jcdesenvolvimento.informativopv.Util.NumberPickerToStringPicker;

import java.util.Calendar;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InformativoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InformativoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformativoFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private EditText edtTituloInformativo;
    private ImageView imgInformativo;
    private Button btnSalvar;
    private Boletim objInformativo;
    private Calendar cal;
    private int iMonth;
    private int iYear;
    private String sMonth;
    private Constants constants;
    private Functions functions;

    public static final int STORAGE_IMAGE = 1;

    public InformativoFragment()  {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformativoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformativoFragment newInstance(String param1, String param2) {
        InformativoFragment fragment = new InformativoFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_informativo, container, false);

        functions = new Functions();

        edtTituloInformativo = (EditText) v.findViewById(R.id.edt_titulo_informativo_editar);
        imgInformativo = (ImageView) v.findViewById(R.id.img_titulo_informativo);
        imgInformativo.setOnClickListener(this);
        btnSalvar = (Button) v.findViewById(R.id.btn_salvar_informativo);
        btnSalvar.setOnClickListener(this);

        cal = Calendar.getInstance();
       // iMonth = cal.get(Calendar.MONTH);
        iYear = cal.get(Calendar.YEAR);

        loadExtra();
        setValuesViews();

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
            case R.id.btn_salvar_informativo:
                CRUD crud = new CRUD(getActivity());
                crud.insertBoletim(objInformativo);
                Toast.makeText(getActivity(),getString(R.string.sucesso_gravar_boletim),Toast.LENGTH_LONG).show();
                loadInformativo();
                break;
            case R.id.img_titulo_informativo:
                getImgStorage();
                break;
        }

    }

    public void loadInformativo(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
         MenuFragment menuFragment = new MenuFragment();
        //Cria Bundle para passar info para outro fragment
        Bundle bundle = new Bundle();
        bundle.putSerializable("objBoletim", objInformativo);
        menuFragment.setArguments(bundle);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container_fragment,  menuFragment);
        ft.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == STORAGE_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bmp =  BitmapFactory.decodeFile(picturePath);

            byte[] imgbyte = functions.bitmapToByte(bmp);
            objInformativo.setiImagem(imgbyte);
            setValuesViews();
        }
    }

    public void loadExtra(){
        Bundle extras = getArguments();
        iMonth = extras.getInt("mes");
        if (extras.getSerializable("obj") != null){
          objInformativo = (Boletim) extras.getSerializable("obj");
        }else{
            createObj();
        }
    }

    public void  createObj(){

        if (objInformativo == null){
            objInformativo = new Boletim();
            objInformativo.setiMes(iMonth);
            objInformativo.setiAno(iYear);
            constants = new Constants();
            String sTitulo = constants.MESES[iMonth].toString()+" / "+Integer.toString(iYear);
            objInformativo.setTitulo(sTitulo);
        }
    }

    public void setValuesViews(){
        edtTituloInformativo.setText(objInformativo.getTitulo().toString());
        if (objInformativo.getiImagem() != null){
            imgInformativo.setBackgroundResource(0);
            imgInformativo.setImageBitmap(functions.byteToBitmap(objInformativo.getiImagem()));
        }


    }



    public void getImgStorage(){
       // Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        getActivity().startActivityForResult(intent,STORAGE_IMAGE);
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
