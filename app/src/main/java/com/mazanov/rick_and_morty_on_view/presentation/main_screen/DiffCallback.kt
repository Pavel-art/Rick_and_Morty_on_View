package com.mazanov.rick_and_morty_on_view.presentation.main_screenimport androidx.recyclerview.widget.DiffUtilimport com.mazanov.rick_and_morty_on_view.domain.models.PersonModelclass DiffCallback {    companion object {        val comparator = object : DiffUtil.ItemCallback<PersonModel>() {            override fun areItemsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {                return oldItem.id == newItem.id            }            override fun areContentsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {                return oldItem == newItem            }        }    }}