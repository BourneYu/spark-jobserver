package spark.jobserver

import org.apache.spark.sql.SQLContext

/**
 * Defines a Job that runs on a [[SQLContext]], note that
 * these jobs are usually long running jobs and there's (yet) no way in Spark
 * Job Server to query the status of these jobs.
 */
trait SparkSqlJob extends SparkJobBase {
  type C = SQLContext
}
