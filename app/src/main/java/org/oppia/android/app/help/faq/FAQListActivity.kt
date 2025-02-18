package org.oppia.android.app.help.faq

import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.oppia.android.app.activity.ActivityComponentImpl
import org.oppia.android.app.activity.InjectableAppCompatActivity
import org.oppia.android.app.help.faq.faqsingle.FAQSingleActivity
import javax.inject.Inject

/** The FAQ page activity for placement of different FAQs. */
class FAQListActivity : InjectableAppCompatActivity(), RouteToFAQSingleListener {

  @Inject
  lateinit var faqListActivityPresenter: FAQListActivityPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (activityComponent as ActivityComponentImpl).inject(this)
    faqListActivityPresenter.handleOnCreate()
  }

  companion object {
    fun createFAQListActivityIntent(context: Context): Intent {
      return Intent(context, FAQListActivity::class.java)
    }
  }

  override fun onRouteToFAQSingle(question: String, answer: String) {
    startActivity(FAQSingleActivity.createFAQSingleActivityIntent(this, question, answer))
  }
}
