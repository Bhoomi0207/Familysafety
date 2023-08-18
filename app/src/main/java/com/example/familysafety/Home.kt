package com.example.familysafety

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Home : Fragment() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater:LayoutInflater, container:ViewGroup?,
        savedInstanceState:Bundle?
    ):View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view:View, savedInstanceState:Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMembers = listOf<MemberModel>(
            MemberModel(
                "Lokesh",
                "9th Building ,2ndfloor ,muradnagar,ghaziabad",
                "80%",
                "220"
            ),
            MemberModel(
                "Anuj",
                "10th Building ,3rdfloor ,muradnagar,ghaziabad",
                "85%",
                "210"
            ),
            MemberModel(
                "Ansh",
                "7th Building ,4thfloor ,muradnagar,ghaziabad",
                "87%",
                "240"
            ),
            MemberModel(
                "Sryansh",
                "5th Building ,6thfloor ,muradnagar,ghaziabad",
                "90%",
                "250"
            ),
            MemberModel(
                "Pari",
                "6th Building ,6thfloor ,muradnagar,ghaziabad",
                "91%",
                "320"
            ),
            MemberModel(
                "Bhoomi",
                "4th Building ,1stfloor ,muradnagar,ghaziabad",
                "90%",
                "210"
            ),
            MemberModel(
                "Riya",
                "5th Building ,2ndfloor ,muradnagar,ghaziabad",
                "81%",
                "200"
            ),

            )
        val adapter = MemberAdapter(listMembers)
        val recyler = requireView().findViewById<RecyclerView>(R.id.recycler_member)
        recyler.layoutManager = LinearLayoutManager(requireContext())
        recyler.adapter = adapter




        val listContacts= listOf<ContactModel>(
            ContactModel("Saumya","1234567890"),
            ContactModel("Soniya","1234567890"),
            ContactModel("Aditya","1234567890"),
            ContactModel("Ankit","1234567890"),
            ContactModel("Shivam","1234567890")

        )
       suspend fun insertDatabaseContacts(){
            val database= MyFamilyDatabase.getDatabase(requireContext())
            database.contactDao().insertAll(listContacts)
        }



        val inviteAdapter = InviteAdapter(listContacts)

        val inviteRecycler = requireView().findViewById<RecyclerView>(R.id.recycler_invite)
        inviteRecycler.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        inviteRecycler.adapter=inviteAdapter


    }



  /*  @SuppressLint("Range")
    private fun fetchContacts():ArrayList<ContactModel> {


        val cr=requireActivity().contentResolver
        val cursor=cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null)

        val listContacts:ArrayList<ContactModel> =ArrayList()

        if(cursor!=null && cursor.count>0){
            while (cursor!=null && cursor.moveToNext()){
                val id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val hasPhoneNo=cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))

                if(hasPhoneNo>0){
                    val pCur=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"= ?",
                      arrayOf(id),
                    ""
                    )
                    if(pCur !=null && pCur.count>0){
                        while(pCur!=null && pCur.moveToNext()){
                            val phonenum=pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            listContacts.add(ContactModel(name,phonenum))
                        }
                        pCur.close()
                    }

                }
            }
            if(cursor!=null){
                cursor.close()
            }

        }
        return listContacts

    }*/

    companion object {

        @JvmStatic
        fun newInstance()=Home()
    }
}