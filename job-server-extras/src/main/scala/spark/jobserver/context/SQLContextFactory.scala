package spark.jobserver.context

import com.typesafe.config.Config
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SQLContext
import org.apache.spark.streaming.{Milliseconds, StreamingContext}
import spark.jobserver.{SparkSqlJob, ContextLike, SparkStreamingJob, api}

class SQLContextFactory extends ScalaContextFactory {

  type C = SQLContext with ContextLike

  def isValidJob(job: api.SparkJobBase): Boolean = job.isInstanceOf[SparkSqlJob]

  def makeContext(sparkConf: SparkConf, config: Config, contextName: String): C = {
    new SQLContext(new SparkContext(sparkConf)) with ContextLike {
      def stop() { this.sparkContext.stop() }
    }
  }
}
