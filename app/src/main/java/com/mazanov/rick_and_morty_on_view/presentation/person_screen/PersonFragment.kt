package com.mazanov.rick_and_morty_on_view.presentation.person_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mazanov.rick_and_morty_on_view.R
import com.mazanov.rick_and_morty_on_view.databinding.FragmentPersonBinding
import com.mazanov.rick_and_morty_on_view.domain.models.PersonModel


class PersonFragment : Fragment() {


    private lateinit var person: PersonModel
    private var _binding: FragmentPersonBinding? = null
    private val binding: FragmentPersonBinding
        get() = _binding ?: throw RuntimeException("FragmentPersonBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().getParcelable<PersonModel>(PERSON_ARGS)?.let {
            person = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchBack()
        initViews()
        addToFavourite()
    }


    private fun addToFavourite() {
        binding.addToFavourite.setOnClickListener {
            Toast.makeText(requireContext(), "Add to Favourite", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initViews() {
        val statusColor = when (person.status) {
            "Alive" -> R.color.status_alive
            "Dead" -> R.color.status_dead
            else -> {
                R.color.white
            }
        }

        with(binding) {
            ivStatus.background.setTint(ContextCompat.getColor(requireContext(), statusColor))
            tvName.text = person.name
            tvStatus.text = person.status
            tvGender.text = person.gender
            tvSpecies.text = person.species
            tvLocationName.text = person.location.name
            tvOriginName.text = person.origin.name
            tvCreated.text = person.created
            addAvatarImageFromGlide(person.image, mainAvatar)
        }
    }

    private fun addAvatarImageFromGlide(
        url: String,
        imageSrc: ImageView
    ) {
        Glide
            .with(requireContext())
            .load(url)
            .placeholder(R.color.background_card)
            .into(imageSrc);
    }


    private fun launchBack() {
        binding.ibBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }


    companion object {

        private const val PERSON_ARGS = "person_args"

        fun newInstance(person: PersonModel) =
            PersonFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PERSON_ARGS, person)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}