package com.example.capiter.ui.products

import androidx.lifecycle.MutableLiveData
import com.example.capiter.common.BaseViewModel
import com.example.capiter.common.Constants
import com.example.capiter.network.model.Product
import com.example.capiter.repository.Repo
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

class ProductsViewModel @Inject constructor(private val repo: Repo) :
    BaseViewModel<ProductsViewState>() {
    private var page = AtomicInteger(Constants.PAGINATION_START)
    private val disposables = CompositeDisposable()
    override val _viewState = MutableLiveData<ProductsViewState>().apply { ProductsViewState() }

    init {
        getProducts()
    }

    fun getProducts() {
        if (page.get() == Constants.PAGINATION_START)
            setState { copy(loading = true, error = null) }
        else
            setState { copy(loadingMore = true, error = null) }
        repo.getProducts(page.get()).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getProductsObserver())
    }

    fun refresh() {
        page = AtomicInteger(Constants.PAGINATION_START)
        getProducts()
    }

    private fun getProductsObserver(): SingleObserver<List<Product>> {
        return object : SingleObserver<List<Product>> {
            override fun onSubscribe(d: Disposable) {
                disposables.add(d)
            }

            override fun onSuccess(products: List<Product>) {
                page.incrementAndGet()
                setState { addProducts(products) }
            }

            override fun onError(e: Throwable) {
                setState { copy(loading = false, loadingMore = false, error = Exception(e)) }
            }
        }
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    private fun setState(block: ProductsViewState.() -> ProductsViewState) {
        setState(ProductsViewState(), block)
    }
}